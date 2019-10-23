package com.turing.service;

import java.util.List;

import com.turing.entity.Car;
/**
 * ҵ���ӿ�
 * @author fred
 *
 */
public interface ICarService {

	//��ѯ����
	Car findById(Integer id);
	
	//��ѯ���
	List<Car> findAll();
	
	//���
	int insert(Car car);
	
	//�޸�
	int update(Car car);
	
	//ɾ��
	int delete(Integer id);
}
