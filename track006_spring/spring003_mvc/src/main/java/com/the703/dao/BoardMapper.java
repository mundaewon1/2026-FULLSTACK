package com.the703.dao;

import java.util.List;
import com.the703.dto.BoardDto;

@Mapper
public interface BoardMapper {
	public int insert(BoardDto dto);
	public int update(BoardDto dto);
	public int delete(int bno);
	
	public List<BoardDto> selectAll();
	public	    BoardDto  select(int bno);

}

/*
create : insert into  mvcboard2 (bname , bpass , btitle , bcontent , bip)  
values  (   #{bname} , #{bpass} , #{btitle} , #{bcontent} , #{bip} )
read   : select * from mvcboard2  order by bno desc
select * from mvcboard2  where  bno= #{bno}
update : update  mvcboard2  set  btitle=#{btitle}  , bcontent=#{bcontent}  where bno= #{bno}
delete : delete  from mvcboard2  where bno= #{bno} 
*/