package com.aavn.rs.dao.impl;

import org.springframework.stereotype.Repository;

import com.aavn.rs.dao.ISkillDAO;
import com.aavn.rs.domain.Skill;

@Repository
public class SkillDAO<T extends Skill> extends CommonDAO<Skill> implements ISkillDAO{


}
