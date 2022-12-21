# CSC120-FinalProject

## Deliverables:
 - Your final codebase
 - Your revised annotated architecture diagram
 - Design justification (including a brief discussion of at least one alternative you considered)
 - A map of your game's layout (if applicable)
 - `cheatsheet.md`
 - Completed `rubric.md`
  
## Additional Reflection Questions
 - What was your **overall approach** to tackling this project?
A: Overall, there was three key components to completing and finalizing this project: collaborative sessions, individual work, and consistent communication. 
During our colaborative sessions, we would verbalize and discuss potential options that would be the most proficient and the layout we want to achieve. We also create mini goals for each of us to complete on our own. A semester of speaking with classmates, TAs and going to Office Hours has soldified with us that communication is key. Whether it be discussing a bug or an idea or how you want to approach something, having someone to bounce ideas off of and give feedback is crucial.

 - What **new thing(s)** did you learn / figure out in completing this project?
A: For this final project, we learned or at the very least solidified the concept of a lot of things. For one, we learned how helpful architecture diagrams can be for planning out code. Before this point, generally speaking, pseudocode would be used. Architecture diagrams have all the benefits of pseudocode and have the benefit of being specific and actionable. Additionally, we learned how to implement a hashmap which really helped fixing logical errors that would occur when we used booleans before.

 - Is there anything that you wish you had **implemented differently**?
A: We would have liked to see how a hashmap would have worked for the inventory so that each item would have its name as a key and some details about it as its corresponding value.
This would allow us to add an "observe" command so that the user could see details the object to gain more information about it, and hints on where to use it.

We would also use generics to make our code less repetitive. There was a point where we got very close to implementing the use of a generic ArrayList or a Pair but we were not able to get things working the way we wanted so we made our own workaround by returning an ArrayList of just strings that was then checked for certain values in the main game loop, for example
Besides that, we probably would have made the crush interface more interactive, and have a way to "win" the crush's heart with special endings for each character.

 - If you had **unlimited time**, what additional features would you implement?
A: Originally, our plan was to randomly generate a crush we a random name, gender and both positive and negative attributes that were in an arraylist. Although, unfortunately, due to time constrainsts and other factors, we weren't able to include that. Additionally, if there was unlimited time, we'd create more choices for the player gain or lose points. Also, we'd include more Smith locations. Finally, we'd make the boss battle with the minotaur more intricate.

 - What was the most helpful **piece of feedback** you received while working on your project? Who gave it to you?
A: One of the most helpful pieces of feedback was from the group with the Spy Escape Room. After they saw our code and we expressed our concern on distinguishing what needed to be a method and what needed to be a class. They affirmed that they too had that issue and were able to articulate how they decided so we could do the same.

 - If you could go back in time and give your past self some **advice** about this project, what hints would you give?
A: One piece of advice would be to explain your thoughts and ideas to anyone that will listen. Even if the person isn't fluent in java or computer science, being forced to explain the ideas floating around in your head really helps clear things up. Additionally, architecture diagrams should be used to the fullest extent and can be changed as the project progresses. Also, don't be afraid to experiment and explore your ideas, it doesn't hurt to try and it could be exactly the solution that you're looking for. Sometimes you may also need to take things apart before you can put them together again and progress further.

 - _If you worked with a team:_ please comment on how your **team dynamics** influenced your experience working on this project.
A: Team dynamics made working on this project a breeze. Since we both had a rapport before the project, we were able to work together well. Of course with other classes, differing schedules, and life it was still an active effort and challenge to stay on the same page but through communication we were able to stay on track. Typically there would be certain things we'd do together and other chunks of the work we'd get done on our own, and we would decide what each of us should work on during our meet-ups before going our seperate ways. If we encountered a particularly confusing roadblock and were both feeling stumped, we would do some pair programming. Having each other to bounce ideas off of really helped to progress things.