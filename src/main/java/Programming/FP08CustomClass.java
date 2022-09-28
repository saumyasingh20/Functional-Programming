package Programming;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class Course {
	private String name;
	private String category;
	private int reviewScore;
	private int noOfStudents;

	public Course(String name, String category, int reviewScore, int noOfStudents) {
		super();
		this.name = name;
		this.category = category;
		this.reviewScore = reviewScore;
		this.noOfStudents = noOfStudents;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getReviewScore() {
		return reviewScore;
	}

	public void setReviewScore(int reviewScore) {
		this.reviewScore = reviewScore;
	}

	public int getNoOfStudents() {
		return noOfStudents;
	}

	public void setNoOfStudents(int noOfStudents) {
		this.noOfStudents = noOfStudents;
	}

	public String toString() {
		return name + ":" + noOfStudents + ":" + reviewScore;
	}

}
public class FP08CustomClass {

	public static void main(String[] args) {
		List<Course> courses = List.of(new Course("Spring", "Framework", 98, 20000),
				new Course("Spring Boot", "Framework", 95, 18000), 
				new Course("API", "Microservices", 97, 22000),
				new Course("Microservices", "Microservices", 96, 25000),
				new Course("FullStack", "FullStack", 91, 14000), 
				new Course("AWS", "Cloud", 92, 21000),
				new Course("Azure", "Cloud", 99, 21000), 
				new Course("Docker", "Cloud", 92, 20000),
				new Course("Kubernetes", "Cloud", 91, 20000));
		
		//allMatch, noneMatch, anyMatch
		
		Predicate<Course> reviewScoreGreaterThan95Predicate = course -> course.getReviewScore()> 95;
		
		Predicate<Course> reviewScoreGreaterThan90Predicate = course -> course.getReviewScore()> 90;
		
		Predicate<Course> reviewScoreLesserThan90Predicate = course -> course.getReviewScore()< 90;
		
		System.out.println(
				courses.stream().allMatch(reviewScoreGreaterThan95Predicate));
		
		System.out.println(
				courses.stream().noneMatch(reviewScoreGreaterThan95Predicate));
		
		System.out.println(
				courses.stream().noneMatch(reviewScoreLesserThan90Predicate));
				
		System.out.println(
				courses.stream().anyMatch(reviewScoreGreaterThan95Predicate));
		
		//sorting using comparators - by number of students
		Comparator<Course> comparingByNumOfStudentsIncreasing = Comparator.comparingInt(Course::getNoOfStudents);
		
		Comparator<Course> comparingByNumOfStudentsDecreasing = Comparator.comparingInt(Course::getNoOfStudents).reversed();
		
		System.out.println(
				courses.stream().sorted(comparingByNumOfStudentsIncreasing).collect(Collectors.toList()));
		
		System.out.println(
				courses.stream().sorted(comparingByNumOfStudentsDecreasing).collect(Collectors.toList()));
		
		Comparator<Course> comparingByNumOfStudentsAndReviewScore = Comparator.comparingInt(Course::getNoOfStudents).thenComparingInt(Course::getReviewScore);
		
		System.out.println(
				courses.stream().sorted(comparingByNumOfStudentsAndReviewScore).collect(Collectors.toList()));
		
		//limit - limiting the no. of items in the list
		System.out.println(
				courses.stream()
				.sorted(comparingByNumOfStudentsAndReviewScore)
				.limit(5)
				.collect(Collectors.toList()));
		
		//skip - skipping the items in the list
				System.out.println(
						courses.stream()
						.sorted(comparingByNumOfStudentsAndReviewScore)
						.skip(3)
						.collect(Collectors.toList()));
				
		//combining both operations - limit and skip
				System.out.println(
						courses.stream()
						.sorted(comparingByNumOfStudentsAndReviewScore)
						.skip(3)
						.limit(2)
						.collect(Collectors.toList()));
				
		/*take while - 	return all the elements of the list 
		 				until one of the item does not meet the criteria
		*/
				System.out.println(
						courses.stream()
							  .takeWhile(course -> course.getReviewScore()>=95)
							  .collect(Collectors.toList()));
				
		/*drop while - 	keeps on dropping / skipping the items if 
		 * 				they satisfy the criteria 
		 */
				System.out.println(
						courses.stream()
						.dropWhile(course -> course.getReviewScore()>=95)
						.collect(Collectors.toList()));		


}}
