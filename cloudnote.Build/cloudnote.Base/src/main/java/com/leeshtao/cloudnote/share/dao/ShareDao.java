package com.leeshtao.cloudnote.share.dao;

import java.util.List;
import java.util.Map;

import com.leeshtao.cloudnote.share.entity.Share;


public interface ShareDao {
	void save(Share share);
	List<Share> findLikeTitle(Map params);
	List<Share> findById();
	Share findByNoteIdAndTitle(Map map);
}
