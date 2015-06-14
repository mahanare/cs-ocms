Phase 1 use cases for OCMS

# Introduction #

Please refer to the data model definition that is provided in another wiki page.

  * Global actors
    * Visitors
    * Logged in users
    * System (OCMS & all the OCMS modules)
  * Notations
    * the word 'he'/'He' will be used to represent user, it is generic usage and has no gender bias. All users to the OCMS are treated equally as long as they adhere to the licensing term of usage of the application.


# Use case definitions #

## User registration ##
### Actors ###

  * Individuals (people who need help or their relatives/neibhours etc
  * Organizations (voluntary organizations, corporates, govt organizations

### Definition ###
  * User will visit OCMS home page
  * Click on the 'New registration' option in the home page.
  * Login page will be displayed
  * User will enter following details
    * Captcha image validation (to avoid spam registrations)
    * Email id
    * Password
    * Confirm password
    * First Name (This is applicable even for organizations, first name of the user, not  org)
    * Last Name
    * DOB
    * Anniversary
    * User type:Individual or representing organization  (radio buttons,by default 'individual' will be selected
      * If representing organization
        * System will show list of organizations registered
        * User will associate himself with one of the organization
        * In case if the organization is not listed,
          * User will be shown option to register organization
          * User can register new organization details
          * Refer to the organization registration user case for further details on the same
    * System will present different types of cases
    * User will select type of cases he is interested in.
    * User can select as many type of cases as he is interested in (we can think of adding a cap on this)
    * Mandatory fields are (Email id, password,first name, DOB, user type)
  * User will be sent  a confirmation email, asking him to validate his details (to avoid impersonation.
  * User need to confirm by clicking the link given in the email URL.
### Login with social network authentication ###
It is proposed to simplify the user authentication mechanism by allowing user to login with the existing account credentials of google, linkedin, facebook or twitter.



## User profile management ##
### Actors ###
  * Logged in users

### Definiton ###
  * This module is related with user registration, but user need not complete full fledged profile details, during registration, hence this module provides the user to modify/add his profile details.
  * This module allows user to
    * Specify his profession (Doctor/Lawyer/Software professional)
    * Office address
    * Contact details
    * Case type and Case sub type registration and modification (use can un-register for a specific type any point of time).
    * Help Category (Donors/Doctors can pledge this help), so that specific cases can be brought to user attention (through mails).

## Home page for logged in Users ##
### Actors ###
  * Logged in users
### Definition ###

  * System will display user following information
    * Menu bar (Horizontal with application modules based on the user role)
    * A panel with status details of the cases he has created and is participating(donations/guidance/volunteer).
    * A panel with all recent cases (belonging to the user interest)
    * If the user is an administrator he will admin related options as well.


## Security/User authentication and authorization ##
### Actors ###
  * Admin users
  * System
  * Users
### Definition ###
  * User authentication
    * user is authenticated based on userid (email id) and password
    * If user has forgot password, a generated password will be sent to his email id based on the user request.
    * User password will be encrypted and hence cannot be seen by administrators or DBAs. It will be based on one way hash.
  * Authorization
    * Application is divided into modules.
    * Each module has the following permissions
      * READ
      * EDIT/MODIFY
      * ADD
      * APPROVE
      * DELETE
    * Each user will be associated with set of modules (case management is the core module  each user will be associated with with READ & ADD permissions).
    * User will belong to roles for modules.
    * Permissions will be managed based on Role
    * For any module user will get authorization if he belongs to module and has associated Role.
    * Menu options (in the logged in home page) will be based on the user modules and roles.
    * Symfony framework will assist to manage security for logged in users.
    * Seperate admin modules will be created to manage permissions and define roles.


## Case registration ##
### Actors ###
  * System
  * Users
### Definition ###
  * All logged in users can register new cases
  * Following procedure/fields will be used for new case registration
    * Case type (Medical,Farmer,Student etc) -> Will be populated by system.
    * Case sub type(sub category, specific to the case type selected -> populated based on
the case type)
    * Help category (Reference table need to be defined with types of helps possible, like financial/guidance/references/ etc)
    * Person Name
    * DOB
    * Gender
    * Email id (if applicable)
    * contact numbers(max of 3)
    * address (line1, line 2, line 3, area/town/village, city/district,State,Postal code)
    * Case description
    * Cost estmiated (rough estimates, if required only)
    * Relavant documents scanned copeis to be uploaded

## Case life cycle ##
### Actors ###
  * System
  * Users (Users, Moderators,Admin)
### Definition ###
  * Following are the life cycle steps of every case.
    * When a new case is registered with the site, It will be updated into database and the status will be 'Pending'
    * A moderator/Volunteer will visit/Call the needy and verify the details and authenticity of the case
    * Specific time lines should be enforced for verification, there must be an escalation matrix defined, so as each case is attended to.
    * When a case is verified by moderator, the status will be updated to 'New'
    * List of approvers based on the case type will be intimated about the new case created.
      * All the approvers have mark the case as approve or reject.  He/She can seek more information by asking for more information.
    * Once the Majority of the users approve the case the case is Marked as  Approved.
    * When the status becomes 'Approved', a mailer will be sent out to the members/organizations  with the case details.
    * Also case details will be published on the home page once the users log in to the system
    * Interested Users/organizations will attend to specific cases and provide their contribution, they can pledge their help by added new artifacts, comments to the case.
    * Any updations to the case,will be published to all the users who have shown interest in this case. It will be via email. We can think of SMS in the future versions of OCMS.
    * Regular users will be shown the case details base on his/her interest. They can contirbute (provide their contribution information, Admin will verify the transaction, once verified an email and digital receipt will be sent to him).
    * Success scenario
      * Needy/(User who registered the case) will confirm that help is received and the ase is closed
      * Status of the case will become 'CONFIRM\_CLOSURE'
      * Moderator / Administrator will confirm closer and the case will be closed (status will be changed to 'CLOSED' by the system.
    * Abandoned scenario
      * It might happen that the case is not attended by anyone, and is pending for long time, an admin screen will be displayed for moderators/administrators for the particular case types.
      * Moderator/Admin will change the status to 'Abandoned'.
    * Cancel scenario
      * A case is registered but the user who created it feels that the case is not valid or help is not required, he can 'Cancel' the case.
        * If user cancels the case before the status being 'New' it will be closed immediately.
        * If the case is active and user feels it doesn't require any help further, it can go into normal mode of closing the case.

  * Only cases with 'Active'/'New' will be shown/published to the users.
  * 'Abandoned'/'Closed'/'Cancelled' will be the END of life cycle of any case.

## Case Type Management ##
### Actors ###
  * Moderators/Administrators

### Definition ###
  * OCMS will have admin module for 'Case Type Management'.
  * Authentication and authorization will be implemented as discussed in 'Security Use case'
  * This module will provide options for
    * Add a new case type
    * Modify details of existing case types (description/Name)
    * Obsolute  case type (meaning, the case type is not valid further, and all the cases with Obsolute case type are not available for general users). This is an extreme step and should be used with caution and can be executed by the adminitrator of OCMS site.

## Case Sub Type Management ##
### Actors ###
  * Moderators/Administrators

### Definition ###
  * OCMS will have admin module for 'Case Sub Type Management'
  * This module will provide options (For a given case type)
    * Add a new 'Case Sub Type'
    * Modify an existing 'Case Sub Type'
    * Obsolute - Similar to the description given in 'Case Type Management' use case.

## Help Category Management ##
### Actors ###
  * Moderators/Administrators

### Definition ###
  * OCMS will have admin module for 'Help Category Management'
  * This module will provide options
    * Add a new 'Help Category'
    * Modify an existing 'Help Category'
    * Obsolute - Similar to the description given in 'Case Type Management' use case.

## Organization type Management ##
### Actors ###
  * Moderators/Administrators

### Definition ###
  * This module allows
    * Add a new org type
    * Modify existing org type information
    * Obsolute org type info
    * Un-Obsolute org type info.


## Emailer service ##
### Actors ###
  * System

### Definition ###
  * OCMS will have 'Email service' to send out mails for various application needs.
  * It will have the following
    * Templates
    * Scheduled mailers
    * On demand mailers.
  * Templates
    * OCMS will have email templates addressing different scenarios of the application.
    * An admin module will be created to manage email template.
      * Add a template
      * Modify a template
      * Obsolute a template
      * Activate a template
  * Schedulers
    * An admin module will be created to send out email notifications on regular intervals. It will have
      * Add a new scheduler
        * scheduler needs the following
          * A template (reference)
          * Logic - This may not be built on the fly by the admin, but might require coding, so this needs discussions.
          * Scheduled frequency (Monthly/Weekly etc)
      * Modify a schedule
      * Obsolute a schedule
    * On demand mailers
      * Application will use templates and send out emails as and when required.





[is another format of the requirements](http://code.google.com/p/ocms/wiki/requirements)


