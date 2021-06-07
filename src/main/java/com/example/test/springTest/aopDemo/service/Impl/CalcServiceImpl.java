package com.example.test.springTest.aopDemo.service.Impl;

import com.example.test.springTest.aopDemo.service.CalcService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CalcServiceImpl implements CalcService {

	@Override
	public int div(int x, int y) {
		int result = x / y;
		System.out.println("===>CalcServiceImpl被调用，计算结果为：" + result);
		return result;
	}
}