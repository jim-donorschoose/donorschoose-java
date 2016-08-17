
public class GradeLevel {

	private int id;
	private String name;
	
	public static void main(String[] args) {
		
		try {
			GradeLevel mapper = new GradeLevel();
			GradeLevel level = mapper.readGradeLevel("{\"id\":\"1\", \"name\":Grades PreK-2}", GradeLevel.class);
			System.out.println(level.id + " is " + level.name + " years old.");
			System.out.println(mapper.writelevelAsString(level));
		} catch (Exception e) {
			e.printStackTrace();
	}
  }
}
