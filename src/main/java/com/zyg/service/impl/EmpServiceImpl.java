package com.zyg.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zyg.dao.EmpMapper;
import com.zyg.model.Emp;
import com.zyg.service.EmpService;

@Service
public class EmpServiceImpl implements EmpService{
	
	@Autowired
	private EmpMapper empMapper;
	
	//spring 支持的redis
	@Autowired
	private RedisTemplate<Object, Object> redisTemplate;
	
	

	@Override
	@Transactional//开启事物管理.如果报错 就回滚
	public int deleteByPrimaryKey(Integer id) {
		return empMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Emp record) {
		return empMapper.insert(record);
	}

	@Override
	public int insertSelective(Emp record) {
		return empMapper.insertSelective(record);
	}

	@Override
	public Emp selectByPrimaryKey(Integer id) {
		String selectByPrimaryKey = "selectByPrimaryKey";
		System.out.println("selectByPrimaryKey.....");
		//字符串的序列化器 : key 以字符串的形式存到数据库中
		RedisSerializer redisSerializer = new StringRedisSerializer();
		redisTemplate.setKeySerializer(redisSerializer);
		
		//先从redis 数据库中取
		Emp e = (Emp)redisTemplate.opsForValue().get(selectByPrimaryKey+id);
		
		if(null == e) {
			// 处理高并发
			synchronized(this) {
				e = (Emp)redisTemplate.opsForValue().get(selectByPrimaryKey+id);
				//如果不存在 则查询数据库,并存到redis中
				if(null == e) {
					System.out.println("查询数据库...........");
					e = empMapper.selectByPrimaryKey(id);
					redisTemplate.opsForValue().set(selectByPrimaryKey+id,e);
				}
			}
		}
		return e;
	}

	@Override
	@Transactional//开启事物管理.如果报错 就回滚
	public int updateByPrimaryKeySelective(Emp record) {
		record.setId(10);
		record.setUser("砍呗");
		int updata = empMapper.updateByPrimaryKeySelective(record);
		System.out.println("更新结果: "+updata);
		//这里产生一个错误, 观察事物是否回滚
		int x = 10/0;
		return updata;
	}

	@Override
	public int updateByPrimaryKey(Emp record) {
		return empMapper.updateByPrimaryKey(record);
	}
	
	

	
}
