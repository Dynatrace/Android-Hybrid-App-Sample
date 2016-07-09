package com.realdolmen.freshlypressed.backend;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Controller voor de rest api van freshlypressed demo app
 * 
 * @author Bert Van der Heyden (RealDolmen)
 */
@RestController
public class BackendController {

	@RequestMapping(method = RequestMethod.GET, path = "stories")
	public Result listStories(){
		Result r = new Result();
		
		r.getPosts().add(
				new Post(
						"User Experience Monitoring on a Hybrid application", 
						"<p>What are hybrid applications? Google says: <i>\"Hybrid applications are web applications (or web pages) in the native browser, such as UIWebView in iOS and WebView in Android (not Safari or Chrome). Hybrid apps are developed using HTML, CSS and Javascript, and then wrapped in a native application using platforms like Cordova.\"</i>"
						+ "<br>And I would not be able to say it any better myself.</p>", 
						new Author(
								"Bert Van der Heyden", 
								"http://apmblog.dynatrace.com", 
								"https://answers.dynatrace.com/users/4315/photo/view.html?s=84")));
		
		r.getPosts().add(
				new Post("Automatic Problem Detection with Dynatrace", 
						"<p>Can you imagine&nbsp;automatic problem detection&nbsp;being a&nbsp;reality?! What would it take to make it possible, practical and functional?&nbsp;Over the years we at Dynatrace have seen a lot of PurePaths being captured in small to very large applications showing why new deployments simply fail to deliver the expected user experience, scalability or performance. Since I started my <a href=\"http://bit.ly/sharepurepath\">Share Your PurePath Program</a> a little over a year ago I received about 250 Dynatrace Sessions from our mainly <a href=\"http://bit.ly/dtpersonal\">free trial / personal license</a>&nbsp;users.&nbsp;My free performance analysis not only helped our users to solve their application performance issues, I also gathered many&nbsp;great stories to tell at conferences, my <a href=\"http://bit.ly/onlineperfclinic\">Online Performance Clinics on YouTub</a>e, our <a href=\"http://www.dynatrace.com/en/pureperformance/\">PurePerformance Podcast</a> or through blog posts such as <a href=\"http://apmblog.dynatrace.com/2016/02/23/top-tomcat-performance-problems-database-micro-services-and-frameworks/\">Top Tomcat Performance Problems</a>, <a href=\"http://apmblog.dynatrace.com/2015/01/14/c-performance-mistakes-top-problems-solved-december/\">C# Performance Mistakes</a>, <a href=\"http://apmblog.dynatrace.com/2014/04/16/top-3-php-performance-tips-for-continuous-delivery/\">PHP Performance Hotspots</a>&nbsp;or more!</p>", 
						new Author(
								"Andreas Grabner", 
								"http://apmblog.dynatrace.com/2016/06/23/automatic-problem-detection-with-dynatrace", 
								"https://answers.dynatrace.com/users/2960/photo/view.html?s=84")));
		
		return r;
	}
	
	public static class Result{
		private List<Post> posts = new ArrayList<>();

		public List<Post> getPosts() {
			return posts;
		}
	}
	
	public static class Post{

		private String title;
		private String content;
		private Author author;
		
		public Post(String title, String desc, Author author) {
			this.title=title;
			this.content=desc;
			this.author=author;
		}

		public String getTitle() {
			return title;
		}

		public String getContent() {
			return content;
		}
		
		public Author getAuthor(){
			return author;
		}
	}
	
	public static class Author{
		private String niceName;
		private String URL;
		private String avatarURL;
		
		public Author(String niceName, String URL, String avatarURL) {
			this.niceName = niceName;
			this.URL = URL;
			this.avatarURL = avatarURL;
		}

		public String getNice_name() {
			return niceName;
		}

		@JsonProperty(value="URL")
		public String getURL() {
			return URL;
		}

		public String getAvatar_URL() {
			return avatarURL;
		}
	}
}
