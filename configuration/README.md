# DevSecOps, Agile SDLC, and GitLab - System Configuration

The systems provided are powered by AWS WorkSpaces. You will each be assigned a machine with a username/password for login. Once logged in, there are additional optional steps that you can take to finalize the configuration and verify the presence of required development tools that will be used for the class.

## Using Windows As Configured

* Launch Visual Studio Code from the Start Menu
* Open a Command Window run as Administrator (or optionally "Git Bash" run as Administrator for a more Linux-like experience), and verify the following:
    - OPTIONAL: Add extensions to Visual Studio Code ("Extension Pack for Java" and "GitLab Workflow") - these can be added manually in Visual Studio Code or using the following commands:

    ```
    code --install-extension "vscjava.vscode-java-pack" --force
    code --install-extension "GitLab.gitlab-workflow" --force
    ```

    - Verify the installed developer tools available for use during the course using the following commands:

    ```
    java --version
    javac --version
    node -v
    npm -v
    git --version
    mvn --version
    python --version
    ```
