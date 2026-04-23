package com.the703.basic010_ex;

import com.the703.basic010.UserInfo2;

public class UserInfoSon2 extends UserInfo2{
		public void show() {
			System.out.println(":: 홍길동 아버지이름 	> " + name);	//public
			System.out.println(":: 홍길동 아버지비밀번호 > " + safeCode);	//protected
			//System.out.println(":: 홍길동 아버지집		> " + house);	// 같은 패키지(폴더)가 아님
			//System.out.println(":: 홍길동 아버지아이큐 	> " + iQ);
			System.out.println(":: 홍길동 아버지아이큐 	> " + getiQ());	//private : getters + setters
		}
	}

