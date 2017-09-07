package com.juwon.memo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

class Model {
	List<Memo> list = new ArrayList<>();
	
	public void create(Memo memo) {
		memo.date = LocalDate.now();
		list.add(memo);
		memo.no = list.indexOf(memo) + 1;
	}
	
	public void update(Memo memo) {
		list.set(memo.no - 1, memo);
	}
}
