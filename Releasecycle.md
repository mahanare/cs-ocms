This page documents the release cycle month on month and the targeted functionality.

Primary focus for this iterative approach is:
  1. Provide scope for early feedback.
  1. Immediate targets to work on for the team.

Nothing changes on what goes in for phase 1 of OCMS. But only to provide immediate target and make best use of the team effort.

Let us remind each one of us of the immediate targets that we have to reach.

The production URL for OCMS is: http://ocms-careerscale.rhcloud.com/login


# Iteration 1 /Release 1 #

## Target date : April 6th ##
> The following functionality need to be achieved for this release.:
    * Registration, login./Harinath
    * Open Id integration and corresponding db changes. Mahender/Harinath
    * Back office screens.Rishi/Praveen
    * Emailing functionality.
    * Demo hosting with free/cheaper solutions
    * Testing frameworks/Guidelines for automation - Pankaj

Status: released.

We have slipped on timelines for remaining releases, and actually released another version on June 22nd with optimiized User interface.


TODO for today:
Write proper and simple use cases with detailed requirements.
mention the attributes, table names, if any master data need to be changed etc.



Menu

## **Home page** ##
1. Show only About us, About OCMS,Register, Login links in the top menu in home page.
2. Login link should go to clean simple login page such as.

Role based access:
> Once we login,all menu options are shown to the user. Actually it should be based on the role.
Let us say back office menu items should be shown only to ADMIN.



## **Landing page:** ##
Menu(should be covered as discussed in Menu above) for logged in user, Profile, Add a case, View cases, search

Landing page should show multiple boxes/blocks.

0. Based on the role (if MODERATOR or ADMIN), I must see all pending cases that need approvals.
1. the cases that I am directly involved, my added cases, involved cases.
2. My interested cases (based on the help type and case type.
we have to show these 2 blocks in interesting layout.
ATTENTION:  we can use the same grids that we are using but with no edit buttons.  We should have links to case details page.

## **Case details page:** ##
If I am (logged in user) the creator of the case or I belong to the role of ADMIN or MODERATOR, I should be able to ed
the case details as well.
Otherwise,I  must be able to read the the case details and add my comments or artifacts to the case.
All the attachments to the case should be viewable from the case details page in a proper format.



## **Case approval:** ##
Logged in user (if is a MODERATOR) will see the cases to be approved in the landing page. He can approve or reject or ask for specific clarification.
Only if the majority of the MODERATORs approve the case will go to NEW state And visible for regular users.

## **Notifications:** ##
Mails should be sent to all events that happen in the system.
very few notifications are there at present.

testing framework for UT and then to FT (selenium).





# Iteration 2 /Release 2 #

## Target date : May 11th ##
The following functionality need to be achieved for May relase.
  * Feedback incorporation from release 1.
  * Case lifecycle. Harinath/Mahender
  * Role base access for back office screens - Rishi/Praveen
  * Automated testing with JUnit and for web layer as well.
  * Jenkins local configuration for CI.

# Iteration 3 /Release 3 #

## Target date : June 29th ##
The following are part of this final release for Phase 1.
  * UI changes / Look and Feel as per the initial iterations. Target is to make it usuable web site.
  * All phase 1 use cases to be ready with QA done.
  * Automation in place for each of the page/module.
  * Central jenkins CI configuration in place.
  * **Phase 2 requirements** in place.