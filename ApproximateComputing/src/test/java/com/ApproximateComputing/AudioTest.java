package com.ApproximateComputing;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Repeat;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ApproximateComputing.po.Audio;
import com.ApproximateComputing.po.ImageRecognition;
import com.ApproximateComputing.po.PathPlaning;
import com.ApproximateComputing.po.User;
import com.ApproximateComputing.service.AudioService;
import com.ApproximateComputing.service.ImageRecognitionService;
import com.ApproximateComputing.service.PathPlaningService;
import com.ApproximateComputing.vo.CommonDTO;

import junit.framework.TestCase;
import net.sourceforge.groboutils.junit.v1.MultiThreadedTestRunner;
import net.sourceforge.groboutils.junit.v1.TestRunnable;

@RunWith(SpringJUnit4ClassRunner.class)

@ContextConfiguration(locations = {"classpath:spring/spring-web.xml",
		"classpath:spring/spring-dao.xml",
		"classpath:spring/spring-service.xml",
		"classpath:spring/spring-shiro.xml"})
public class AudioTest{
	@Autowired
	private AudioService audioService;
	
	@Autowired
	private ImageRecognitionService imageRecognitionService;
	
	@Autowired
	private PathPlaningService pathPlaningService;
	
	//客户端多线程并发数目
	private static final int THREAD_COUNT = 200;
	
//	@Test
	public void testAudio()throws Throwable{
		//线程数组，模拟并发
		TestRunnable[]testThreadArray=new TestRunnable[THREAD_COUNT];
		for(int i=0;i<testThreadArray.length;i++){
			testThreadArray[i]=new MultiThreadTestAudio();
		}
		//执行多线程测试用例的Runner
		MultiThreadedTestRunner multiThreadedTestRunner=new MultiThreadedTestRunner(testThreadArray);
		//开始并发执行
		multiThreadedTestRunner.runTestRunnables();
	}
	
//	@Test
	public void testImageRecognition()throws Throwable{
		//线程数组，模拟并发
		TestRunnable[]testThreadArray=new TestRunnable[THREAD_COUNT];
		for(int i=0;i<testThreadArray.length;i++){
			testThreadArray[i]=new MultiThreadTestImageRecognition();
		}
		//执行多线程测试用例的Runner
		MultiThreadedTestRunner multiThreadedTestRunner=new MultiThreadedTestRunner(testThreadArray);
		//开始并发执行
		multiThreadedTestRunner.runTestRunnables();
	}
	
	@Test
	public void testPathPlaning()throws Throwable{
		//线程数组，模拟并发
		TestRunnable[]testThreadArray=new TestRunnable[THREAD_COUNT];
		for(int i=0;i<testThreadArray.length;i++){
			testThreadArray[i]=new MultiThreadTestPathPlaning();
		}
		//执行多线程测试用例的Runner
		MultiThreadedTestRunner multiThreadedTestRunner=new MultiThreadedTestRunner(testThreadArray);
		//开始并发执行
		multiThreadedTestRunner.runTestRunnables();
	}
	
	
	public void createMultiAudio(){
		List<Audio>list=new ArrayList<>();
		Audio audio=new Audio();
		audio.setQualityLossRatio(new Float(10));
		audio.setTime(new Integer(2));
		audio.setGrade(new Integer(85));
		for(int i=0;i<16;i++){
			list.add(audio);
		}
		
		CommonDTO result=audioService.createMultiAudioByCallable(list);
//		CommonDTO result=audioService.createMultiAudioByRunnable(list);
		System.out.println("Audio:"+result.getMsg());
	}
	
	private class MultiThreadTestAudio extends TestRunnable{

		@Override
		public void runTest() throws Throwable {
			//业务逻辑
			createMultiAudio();
//			try{
//				Thread.sleep(2000);
//			}catch(InterruptedException e){
//				e.printStackTrace();
//			}
			
		}
		
	}
	
	
	public void createMultiImageRecognition(){
		List<ImageRecognition>list=new ArrayList<>();
		ImageRecognition imageRecognition=new ImageRecognition();
		imageRecognition.setQualityLossRatio(new Float(10));
		imageRecognition.setTime(new Integer(2));
		imageRecognition.setGrade(new Integer(85));
		for(int i=0;i<16;i++){
			list.add(imageRecognition);
		}
		
		CommonDTO result=imageRecognitionService.createMultiImageRecognitionByCallable(list);
//		CommonDTO result=audioService.createMultiAudioByRunnable(list);
		System.out.println("ImageRecognition:"+result.getMsg());
	}
	
	private class MultiThreadTestImageRecognition extends TestRunnable{

		@Override
		public void runTest() throws Throwable {
			//业务逻辑
			createMultiImageRecognition();
//			try{
//				Thread.sleep(2000);
//			}catch(InterruptedException e){
//				e.printStackTrace();
//			}
			
		}
		
	}
	
	
	
	public void createMultiPathPlaning(){
		List<PathPlaning>list=new ArrayList<>();
		PathPlaning pathPlaning=new PathPlaning();
		pathPlaning.setQualityLossRatio(new Float(10));
		pathPlaning.setTime(new Integer(2));
		pathPlaning.setPathLength(new Integer(930));
		pathPlaning.setGrade(new Integer(85));
		for(int i=0;i<16;i++){
			list.add(pathPlaning);
		}
		
		CommonDTO result=pathPlaningService.createMultiPathPlaningByCallable(list);
//		CommonDTO result=audioService.createMultiAudioByRunnable(list);
		System.out.println("PathPlaning:"+result.getMsg());
	}
	
	private class MultiThreadTestPathPlaning extends TestRunnable{

		@Override
		public void runTest() throws Throwable {
			//业务逻辑
			createMultiPathPlaning();
//			try{
//				Thread.sleep(2000);
//			}catch(InterruptedException e){
//				e.printStackTrace();
//			}
			
		}
		
	}
	
}
