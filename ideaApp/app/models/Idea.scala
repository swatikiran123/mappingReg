package models

case class Idea(
	id: Long, name: String, description: String)


object Idea {
	var ideas = Set(
		Idea(5010255079763L, "Ux Transformation", "User ex is critical for app; a framework can help bring uniformity across applications"),
		Idea(5018206244666L, "MicroServices Model", "MicroServices are gaining popularity these days. Adopt MicroServices for application development"),
		Idea(5018306332812L, "Improve Ideation Platform", "Every business group is interested in ideation exercizes. A standard organization wide tool can help in building a common ideation model as well as saving cost in ideation exercises")
	)
	
	def findAll = ideas.toList.sortBy(_.id)
}