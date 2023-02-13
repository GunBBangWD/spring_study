package study04;

import java.util.Date;
import java.util.Locale;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CalendarRun {
	public static void main(String[] args) {
		//객체 생성
		Calendar cal = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		Calendar cal3 = Calendar.getInstance();
		
		//get
		System.out.print(cal.get(Calendar.YEAR)+"년");
		System.out.print(cal.get(Calendar.MONTH)+1+"월");//0-11
		System.out.println(cal.get(Calendar.DATE)+"일");
		System.out.println(cal.get(Calendar.JANUARY)+">1월");
		System.out.println(cal.get(Calendar.DAY_OF_WEEK));
		System.out.println(Calendar.DAY_OF_WEEK);
		System.out.println(Calendar.FRIDAY);
		System.out.print(cal.get(Calendar.HOUR)+"시");
		System.out.print(cal.get(Calendar.MINUTE)+"분");
		System.out.println(cal.get(Calendar.SECOND)+"초");
		System.out.println(cal.get(Calendar.AM_PM));
		System.out.println(cal.get(Calendar.AM));
		System.out.println(cal.get(Calendar.PM));
		System.out.println(Calendar.PM);
		//getTime()
		System.out.println(cal.getTime());
		//add()
		cal.add(Calendar.MINUTE,5);
		System.out.println(cal.getTime());
		//set()
		cal2.set(1982, 6, 8);
		System.out.println(cal2.getTime());
		cal3.set(2022, 7, 3,15,34,77);
		System.out.println(cal3.getTime());
		//before() after()
		System.out.println(cal2.before(cal3));
		System.out.println(cal2.after(cal3));
		//roll()
		cal2.add(Calendar.HOUR, 24);
		System.out.println(cal2.getTime());
		cal2.roll(Calendar.HOUR, 24);
		System.out.println(cal2.getTime());
		
		//오늘의 날짜와 시간 출력
		//YYYY년 M월 D일 ?요일 AM/PM 시:분:초
		Calendar calendar = Calendar.getInstance();//객체 생성
		
		int year = calendar.get(Calendar.YEAR);//연도
		int month = calendar.get(Calendar.MONTH)+1; //월
		int date = calendar.get(Calendar.DATE); //일자
		int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK); // 요일
		String sDayOfWeek = "";
		switch (dayOfWeek) {
			case Calendar.MONDAY:
				sDayOfWeek = "월요일";
				break;
			case Calendar.TUESDAY:
				sDayOfWeek = "화요일";
				break;
			case Calendar.WEDNESDAY:
				sDayOfWeek = "수요일";
				break;
			case Calendar.THURSDAY:
				sDayOfWeek = "목요일";
				break;
			case Calendar.FRIDAY:
				sDayOfWeek = "금요일";
				break;
			case Calendar.SATURDAY:
				sDayOfWeek = "토요일";
				break;
			case Calendar.SUNDAY:
				sDayOfWeek = "일요일";
		}
		calendar.add(Calendar.HOUR, 8);
		calendar.add(Calendar.MINUTE, 20);
		int ampm = calendar.get(Calendar.AM_PM);//오전0오후1
		String sAmpm = (ampm==Calendar.PM)?"오후":"오전";
		int hour= calendar.get(Calendar.HOUR);//시간(12시간)
		System.out.println(calendar.get(Calendar.HOUR_OF_DAY));//24시간제
		int min= calendar.get(Calendar.MINUTE);//분
		int sec= calendar.get(Calendar.SECOND);//초
		//시분초의 앞자리에 빈공간에 0을 추가
		String sHour = hour<10?("0"+hour):String.valueOf(hour);
		String sMin = min<10?("0"+min):String.valueOf(min);
		String sSec = sec<10?("0"+sec):String.valueOf(sec);
		
		System.out.println(year+"년 "+month+"월 "+date+"일 "+sDayOfWeek);
		System.out.println(sAmpm+" "+hour+":"+min+":"+sec);
		System.out.println(sAmpm+" "+sHour+":"+sMin+":"+sSec);
		System.out.printf("%4s%3d:%2d:%2d",sAmpm,hour,min,sec);
		System.out.println();
		System.out.printf("%4s%4s:%2s:%2s",sAmpm,sHour,sMin,sSec);
		System.out.println();
		System.out.printf("%3s %04d:%02d:%02d",sAmpm,hour,min,sec);
		System.out.println();
		
		Date today = new Date();
		
		SimpleDateFormat format1 = new SimpleDateFormat(
				"yyyy년 MM월 dd일 hh시 mm분 ss초");
		SimpleDateFormat format2 = new SimpleDateFormat(
				"yyyy-MM-dd hh:mm:ss");
		SimpleDateFormat format3 = new SimpleDateFormat(
				"오늘 날짜 : yyyy년도 MM월, 현재 시각 : hh시 mm분");

		System.out.println(today);
		System.out.println(format1.format(today));
		System.out.println(format2.format(today));
		System.out.println(format3.format(today));

		Calendar calendar1 = Calendar.getInstance();
		SimpleDateFormat format = new SimpleDateFormat();
 
		format.applyPattern("yyyy-MM-dd");
		System.out.println(format.format(calendar1.getTime()));
		 
		format.applyPattern("yyyy년 MM월 dd일 h시 m분 s초");
		System.out.println(format.format(calendar1.getTime()));
		 
		SimpleDateFormat format5 = new SimpleDateFormat(
				"EEE MMM dd E a HH:mm:ss zzz yyyy", Locale.US);
		System.out.println(format5.format(calendar1.getTime()));
		 
		SimpleDateFormat format6 = new SimpleDateFormat(
				"EEE MMM dd E a HH:mm:ss zzz yyyy", Locale.JAPAN);
		System.out.println(format6.format(calendar1.getTime()));
			
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
