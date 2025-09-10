package com.example.demo.service;

import com.example.demo.model.Voucher;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.stereotype.Service;

@Service
public class VoucherService {
  private final Map<Long, Voucher> vouchers = new ConcurrentHashMap<>();
  private final AtomicLong idGenerator = new AtomicLong();

  public List<Voucher> findAll() {
    return new ArrayList<>(vouchers.values());
  }

  public Voucher findById(Long id) {
    if (isActive){
        return vouchers.get(id);
    }
  }

  public Voucher create(Voucher voucher) {
    voucher.setId(idGenerator.incrementAndGet());
    //voucher.put(voucher.getId(), voucher);
    return voucher;
  }


}
