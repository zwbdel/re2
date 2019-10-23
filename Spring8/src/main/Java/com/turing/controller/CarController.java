package com.turing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.turing.entity.Car;
import com.turing.service.ICarService;

@Controller
public class CarController {
	
	//����ҵ��㣬ע��ҵ���
	@Autowired
	private ICarService carService;

	//���Է���
	@RequestMapping("/test")
	@ResponseBody //������صĽ����String����ô��ֱ�ӷ���String
	public String test() {
		return "controller success";
	}
	
	//ͨ��id��ѯcar����ʾjson����
	@RequestMapping("/car/{id}")
	@ResponseBody //����JSON�ַ���
	public Car getCar(@PathVariable("id")Integer id) {
		return carService.findById(id);
	}
}
