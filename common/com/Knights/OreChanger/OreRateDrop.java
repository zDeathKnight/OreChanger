package com.Knights.OreChanger;

import java.util.Random;

public class OreRateDrop {
	
	static Random r = new Random();
	
	public static int Coal(){
		int i = r.nextInt(100);
		int drop = 1;
		if(i>70)drop++;
		if(i>82)drop++;	
		if(i>95)drop++;
		return drop;
	}
	
	public static int Iron()
	{
		int i = r.nextInt(100);
		int drop = 1;
		if(i>60)drop++;
		if(i>90)drop++;
		if(i>95)drop++;
		return drop;
	}
	
	public static int Gold()
	{
		int i = r.nextInt(100);
		int drop = 1;
		if(i>40)drop++;
		if(i>70)drop++;
		if(i>95)drop++;	
		return drop;
	}
	
	public static int Diamond()
	{
		int i = r.nextInt(100);
		int drop = 1;
		if(i>70)drop++;
		if(i>86)drop++;
		if(i>97)drop++;	
		return drop;
	}
}
