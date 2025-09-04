# hello-intellij-plugin

Minimal IntelliJ Platform plugin with:
- Two actions (Tools → **Say Hello**, Editor popup → **Insert Hello**)
- Application & Project services
- Notifications

## Run

1) Open this folder in IntelliJ IDEA.
2) Let Gradle sync.
3) Run the Gradle task: **runIde**.

_Note_: This project doesn't include the Gradle Wrapper jar. You can run with your local Gradle,
or generate the wrapper via: `gradle wrapper` (or in IDE: Tools → Gradle → gradle wrapper).
