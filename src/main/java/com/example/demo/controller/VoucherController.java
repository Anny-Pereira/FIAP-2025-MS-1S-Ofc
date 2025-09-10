package com.example.demo.controller;

import com.example.demo.model.Voucher;
import com.example.demo.service.VoucherService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/vouchers")
@Tag(name = "Voucher", description = "Voucher management APIs")
public class VoucherController {
  private static final String SUCCESS_CODE = "200";
  private static final String NOT_FOUND_CODE = "404";
  private static final String ID_PATH = "/{id}";
  private static final String NOT_FOUND_MESSAGE = "Voucher not found";

  private final VoucherService voucherService;

  public VoucherController(VoucherService voucherService) {
    this.voucherService = voucherService;
  }

  @GetMapping
  @Operation(
      summary = "List all Vouchers",
      description = "Returns a list of all vouchers in the system")
  @ApiResponse(responseCode = SUCCESS_CODE, description = "Successfully retrieved list")
  public List<Voucher> getAllVouchers() {
    return voucherService.findAll();
  }

  @GetMapping(ID_PATH)
  @Operation(summary = "Get a voucher by ID", description = "Returns a single voucher by its ID")
  @ApiResponse(responseCode = SUCCESS_CODE, description = "Successfully retrieved voucher")
  @ApiResponse(responseCode = NOT_FOUND_CODE, description = NOT_FOUND_MESSAGE)
  public ResponseEntity<Voucher> getVoucher(@PathVariable Long id) {
    Voucher voucher = voucherService.findById(id);
    return voucher != null ? ResponseEntity.ok(voucher) : ResponseEntity.notFound().build();
  }

  @PostMapping
  @Operation(summary = "Create a new Voucher", description = "Creates a new voucher in the system")
  @ApiResponse(responseCode = SUCCESS_CODE, description = "Successfully created voucher")
  public Voucher createVoucher(@Valid @RequestBody Voucher voucher) {
    return voucherService.create(voucher);
  }
}