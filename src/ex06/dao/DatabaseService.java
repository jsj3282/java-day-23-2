package ex06.dao;

import ex06.Member;

public interface DatabaseService {
	public boolean insert(Member member);
	public Member select(String id);
}
