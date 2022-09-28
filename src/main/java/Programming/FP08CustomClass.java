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
		
		Comparator<Course> comparingByNumOfStudentsAndReviewScore = Comparator.comparingInt(Course::getNoOfStudents).thenComparingInt(Course::getReviewScore).reversed();
		
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
		 * 				they satisfy the condition , as soon as the condition 
		 * 				becomes false it returns the remaining items of list 
		 */
				System.out.println(
						courses.stream()
						.dropWhile(course -> course.getReviewScore()>=95)
						.collect(Collectors.toList()));	
				
			//max - returns the max from a comparator condition
				System.out.println(
						courses.stream()
								.max(comparingByNumOfStudentsIncreasing));
				
				System.out.println(
						courses.stream()
								.max(comparingByNumOfStudentsDecreasing));
				
			//min - returns the min from a comparator condition
				System.out.println(
						courses.stream()
								.min(comparingByNumOfStudentsIncreasing));
				
				System.out.println(
						courses.stream()
								.min(comparingByNumOfStudentsDecreasing));
				System.out.println(
						courses.stream()
						.filter(reviewScoreLesserThan90Predicate)
						.min(comparingByNumOfStudentsAndReviewScore)
						.orElse(new Course("Kubernetes", "Cloud", 91, 20000))
							);
				
			//find first - returns the top / first element
				System.out.println(
						courses.stream()
						.filter(reviewScoreGreaterThan95Predicate)
						.findFirst());
				
				System.out.println(
						courses.stream()
						.filter(reviewScoreLesserThan90Predicate)
						.findFirst()); //returns Optional.empty
				
			//find any - returns any element meeting the criteria
				System.out.println(
						courses.stream()
						.filter(reviewScoreGreaterThan90Predicate)
						.findAny());
			
			//sum, avg and count	
				System.out.println(
						courses.stream()
						.filter(reviewScoreGreaterThan95Predicate)
						.mapToInt(Course::getNoOfStudents)
						.sum());
				
				System.out.println(
						courses.stream()
						.filter(reviewScoreGreaterThan95Predicate)
						.mapToInt(Course::getNoOfStudents)
						.average());
				
				System.out.println(
						courses.stream()
						.filter(reviewScoreGreaterThan95Predicate)
						.mapToInt(Course::getNoOfStudents)
						.count());
				
			//GROUP BY - Group the Courses according to the category
				System.out.println(
						courses.stream()
						.collect(Collectors.groupingBy(Course::getCategory)));
				
				System.out.println(
						courses.stream()
						.collect(Collectors.groupingBy(Course::getCategory, Collectors.counting())));
				
				System.out.println(
						courses.stream()
						.collect(Collectors.groupingBy(Course::getCategory, 
								 Collectors.maxBy(Comparator.comparing(Course::getReviewScore)))));
				
				System.out.println(
						courses.stream()
						.collect(Collectors.groupingBy(Course::getCategory, 
								 Collectors.mapping(Course::getName,Collectors.toList()))));
				System.out.println(
						courses.stream()
						.filter(course -> course.getCategory().contains("Cloud"))
						.collect(Collectors.groupingBy(Course::getCategory,Collectors.counting()))
						);
				System.out.println(
						courses.stream()
						.filter(course -> course.getCategory().contains("Cloud"))
						.collect(Collectors.groupingBy(Course::getCategory,Collectors.averagingInt(Course::getNoOfStudents)))
						);
				Predicate<Course> reviewScoreGreaterThan95Predicate2 
				= createPredicateWithCutoffReviewScore(95);

				Predicate<Course> reviewScoreGreaterThan90Predicate2 
				= createPredicateWithCutoffReviewScore(90);
				

}
	private static Predicate<Course> createPredicateWithCutoffReviewScore(int cutoffReviewScore) {
		return course -> course.getReviewScore() > cutoffReviewScore;
	}
	
	}
