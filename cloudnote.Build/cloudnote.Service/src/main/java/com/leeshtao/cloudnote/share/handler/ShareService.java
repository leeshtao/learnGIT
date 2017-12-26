package com.leeshtao.cloudnote.share.handler;

import java.util.List;

import com.leeshtao.cloudnote.share.entity.Share;


public interface ShareService {
	void saveShareNote(Long noteId);
	List<Share> searchShareNote(String keyword,int page);
}
