# Steps to create a new service repository

* Click "Use this template" button
* Fill in repository name and press "Create repository from template" button 
* Clone the new repository
* Edit `src/main/kotlin/generator/Launcher.kt` by replacing default config values with your values.
* Run script
* Reload files from disk in IDE (just in case)
* Adjust config/detekt/detekt.yml settings or leave it as it is (you can always change it later)
* Commit and push your changes
* After initial deployment, set the newrelic app id in deploy workflow to make use of deployment marker
    
    
