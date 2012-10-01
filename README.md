jrefactor
=========

This is the first example of the book:

Refactoring improving the design of existent code.

I usually want to start with the first example of the book but happens that
I have to
create the project, copy and paste the sample code and write a solid set of
test, this delays me in the refactoring activities.

So if you want to start right away with the first sample of the book,
you can download this project. You will have already the project and the tests.


------------------------------------------------------------------------------
"Refactoring improving the design of existent code"

What are your impressions about the design of this program? 

I would describe it as not well designed and certainly not object oriented. 
For a simple program like this, that does not really matter. There's nothing wrong
with a quick and dirty simple program. But if this is a representative fragment of
a more complex system, then I have some real problems with this program. 
That long statement routine in the Customer class does far too much. 
Many of the things that it does should really be done by the other classes.

Even so the program works. Is this not just an aesthetic judgment, a dislike of ugly code?
It is until we want to change the system. The compiler doesn't care whether the code is ugly
or clean. But when we change the system, there is a human involved, and humans do care.

A poorly designed system is hard to change. Hard because it is hard to figure out 
where the changes are needed. If it is hard to figure out what to change, there is 
a strong chance that the programmer will make a mistake and introduce bugs.


In this case we have a change that the users would like to make. 
First they want a statement printed in HTML so that the statement can be Web enabled 
and fully buzzword compliant. 

Consider the impact this change would have. As you look at the code you can see 
that it is impossible to reuse any of the behavior of the current statement method
for an HTML statement. 

Your only recourse is to write a whole new method that duplicates much of the behavior of statement. 
Now, of course, this is not too onerous. You can just copy the statement method 
and make whatever changes you need.


But what happens when the charging rules change? You have to fix both statement
and htmlStatement and ensure the fixes are consistent. The problem with copying and pasting
code comes when you have to change it later. If you are writing a program that you
don't expect to change, then cut and paste is fine. -- epa !!

If the program is long lived and likely to change, then cut and paste is a menace.


This brings me (the author) to a second change.
The users want to make changes to the way they classify movies, but they haven't
yet decided on the change they are going to make. They have a number of changes in mind.
These changes will affect both the way renters are charged for movies and the way
that frequent renter points are calculated. As an experienced developer you are sure
that whatever scheme users come up with, the only guarantee you're going to have
is that they will change it again within six months.


The statement method is where the changes have to be made to deal with changes in
classification and charging rules.
If, however, we copy the statement to an HTML statement, we need to ensure that 
any changes are completely consistent. Furthermore, as the rules grow in complexity
it's going to be harder to figure out where to make the changes and harder to make
them without making a mistake.


You may be tempted to make the fewest possible changes to the program; after all,
it works fine. Remember the old engineering adage: "if it ain't broke, don't fix it."

The program may not be broken, but it does hurt. 
It is making your life more difficult because you find it hard to make the changes
your users want. This is where refactoring comes in.


---------------------------------------
Some important things to remember
---------------------------------------

Tip
When you find you have to add a feature to a program, and the program's code is
not structured in a convenient way to add the feature, first refactor the program
to make it easy to add the feature, then add the feature.


Before you start refactoring, check that you have a solid suite of tests.
These tests must be self-checking. It is essential for refactoring that you have
good tests, the test give you the security you need to change the program.


Tip
Before you start refactoring, check that you have a solid suite of tests.
These tests must be self-checking.

Tip
Refactoring changes the programs in small steps. If you make a mistake,
 it is easy to find the bug.

Tip
Any fool can write code that a computer can understand. Good programmers write
code that humans can understand.




It is a bad idea to do a switch based on an attribute of another object.
