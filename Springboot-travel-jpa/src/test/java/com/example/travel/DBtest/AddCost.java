package com.example.travel.DBtest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.travel.model.entity.Cost;
import com.example.travel.repository.CostRepository;

@SpringBootTest
public class AddCost {
	
	@Autowired
	CostRepository costRepository;
	
	@Test
	public void test() {
		try {
			Cost cost = new Cost();
			cost.setAmount(200000);
			costRepository.save(cost);
			
			Cost cost1 = new Cost();
			cost1.setAmount(50000);
			costRepository.save(cost1);
			
			Cost cost2 = new Cost();
			cost2.setAmount(180000);
			costRepository.save(cost2);
			
			Cost cost3 = new Cost();
			cost3.setAmount(40000);
			costRepository.save(cost3);
			
			System.out.println("新增完成");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
