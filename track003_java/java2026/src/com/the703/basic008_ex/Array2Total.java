package com.the703.basic008_ex;

import java.util.Arrays;

public class Array2Total {

	public static void main(String[] args) {
	   
		String[] name={"아이언맨","헐크","캡틴","토르","호크아이"};
	    int[] kor={100,20,90,70,35};   // kor  5:0~4
	    int[] eng={100,50,95,80,100};  // 공간빌려오기 동시에 초기화
	    int[] mat={100,30,90,60,100};
	    int[] aver=new int[5];		   // 공간빌려오기 - 들어갈데이터를 모를경우
	    
	    String [] hab=new String[5];
	    String [] jang=new String[5];
	    String [] rank=new String[] {"","","","",""};
	    int hab1=1;
	    int[] su=new int[] {1,1,1,1,1};

	    
	    for(int a=0;a<kor.length;a++) {
	    	aver[a]=(kor[a]+eng[a]+mat[a])/3;
	    
	    	 hab[a]= aver[a]>60? (kor[a]>40 && eng[a]>40 && mat[a]>40? "합격" : "재시험") : "불합격";
//    	 	 if (aver[a]>=60) {hab[a] ="합격";}
//    	 	 else			  {hab[a] ="불합격";}
    	 	 if (aver[a]>=95) {jang[a]="장학생";}
    	 	 else			  {jang[a]="---";}
    	 	 
    	 	 for(int i=0; i<aver[a]/10; i++){rank[a]+="*";}
	    }
	 	 	 
	    	  for(int t=0;t<aver.length;t++) {
    	 	  for(int i=0;i<aver.length;i++) {if(aver[t]<aver[i]) {su[t]+=1;  }}}
//	 	 	  if(aver[0]<aver[1]) {su[0]+=1;  }
//	 	 	  if(aver[0]<aver[2]) {su[0]+=1;  }
//	 	 	  if(aver[0]<aver[3]) {su[0]+=1;  }
//	 	 	  if(aver[0]<aver[4]) {su[0]+=1;  }


//	 	 	  for(int i=0;i<aver.length;i++) {if(aver[1]<aver[i]) {su[1]+=1;  }}
//	 	 	  for(int i=0;i<aver.length;i++) {if(aver[2]<aver[i]) {su[2]+=1;  }}
//	 	 	  for(int i=0;i<aver.length;i++) {if(aver[3]<aver[i]) {su[3]+=1;  }}
//	 	 	  for(int i=0;i<aver.length;i++) {if(aver[4]<aver[i]) {su[4]+=1;  }}
//    	 	  if(aver[1]<aver[0]) {su[1]+=1;  }
//	 	 	  if(aver[1]<aver[1]) {su[1]+=1;  }
//	 	 	  if(aver[1]<aver[2]) {su[1]+=1;  }
//	 	 	  if(aver[1]<aver[3]) {su[1]+=1;  }
//	 	 	  if(aver[1]<aver[4]) {su[1]+=1;  }



    	 	 /*
				switch (aver[a] / 10) {
				case 10: rank[a] = "**********"; break;
				case 9: rank[a] = "*********"; break;
				case 8: rank[a] = "********"; break;
				case 7: rank[a] = "*******"; break;
				case 6: rank[a] = "******"; break;
				case 5: rank[a] = "*****"; break;
				case 4: rank[a] = "****"; break;
				case 3: rank[a] = "***"; break;
				case 2: rank[a] = "**"; break;
				case 1: rank[a] = "*"; break;
				default: rank[a] = ""; break;
				}*/
	    

	    for(int a=0;a<kor.length;a++) {
	    System.out.println((a+1)+"번 학생의 평균 " + aver[a]);}
	    System.out.println();
	    
	    System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::\r\n"
	    		+ "이름\t국어\t영어\t수학\t평균\t등수\t합격여부\t장학생\t랭킹\r\n"
	    		+ ":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
		for(int x=0;x<name.length;x++) {
		System.out.printf("%s\t%d\t%d\t%d\t%d\t%d\t%s\t%s\t%s\n",name[x],kor[x],eng[x],mat[x],aver[x],su[x],hab[x],jang[x],rank[x]);
		}
		System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
	    
	
	}

}
/*1. 평균구하시오.
2. 합격,불합격   -  평균이 60점이상이면 합격, 아니면 불합격으로 처리하시오.
3. 장학생   - 평균 95점이상이면 장학생으로 처리하시오. 
 
3.출력예시:     
:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
이름      국어   영어   수학   평균   합격여부   장학생   
:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
아이언맨   100   100   100   100      합격   장학생   
헐크      20   50   30   33   불합격   ----   
캡틴      90   95   90   91   합격   ----   
토르      70   80   60   70   합격   ----   
호크아이   35   100   100   78      합격   ----   
:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

※ 힌트1)    
/////// 처리1 : 평균구하기  
1-1. (국어+영어+수학)/3
1-2.  아이언맨의 평균 =  아이언맨의 국의 + 아이언맨의 영어 + 아이언맨의 수학 
1-3.  aver[0] = kor[0] + eng[0] + mat[0]

1-2.  헐크의 평균 =  아이언맨의 국의 + 아이언맨의 영어 + 아이언맨의 수학 
1-3.  aver[1] = kor[1] + eng[1] + mat[1]

/////// 처리2 : 합격,불합격 
2-1. 평균이 60점이상이면 합격    아니면 불합격
2-2. 어디다가 합격, 불합격을 담아놓을 것인가? ※ 필요한것 : 합격,불합격을 담을 배열     
2-3. 아이언맨의 평균이 60점 이상이라면 합격 / 아니면 불합격
2-4. if(aver[0] >=60){   합격 } else{불합격} 

/////// 처리3 : 장학생
3-1. 평균 95점이상 장학생
3-2. 어디다가 장학생을 담아놓을 것인가? ※ 필요한것 :  장학생 여부를 저장할 배열 
3-3. 아이언맨의 평균이 95점이상이면 장학생 / 아니라면 ----
3-4.  if(aver[0] >=95){ 장학생 } else{ ---- } */