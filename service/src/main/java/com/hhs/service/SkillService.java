package com.hhs.service;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.hhs.service.BaseService;
import com.hhs.base.model.Skill;
import com.hhs.base.dao.SkillDao;

@Transactional
@Service
public class SkillService extends BaseService<Skill, Integer> {
	@Resource
	private SkillDao dao;

	@Override
	public SkillDao getDao() {
		return dao;
	}
}