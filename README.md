# Shoe Store

A Udacity course project: a multi-screen shoe inventory app. The flow runs Login → Welcome → Instructions → Shoe list → Add shoe, and the shoes you add are kept in memory in a shared ViewModel.

**What it demonstrates**
- The Navigation component with a single-activity nav graph, Safe Args directions, and an `AppBarConfiguration` wired to a navigation drawer
- Data Binding in every fragment, with **two-way binding** (`@={}`) from the add-shoe form to the ViewModel
- An activity-scoped `ViewModel` (`activityViewModels()`) holding a `LiveData` list shared between the list and add screens
- Views inflated dynamically into the list layout, plus an overflow menu with logout

**Run it:** clone `https://github.com/darsh-7/my_sho_store.git`, open it in Android Studio (AGP 4.0 / Kotlin 1.3.72, so expect an upgrade prompt) and run `app` (minSdk 19). Login is UI only: any input continues.

Built for Udacity's Android Kotlin Developer Nanodegree, Developing Android Apps with Kotlin course (2022).

**Author:** Mostafa Ahmed · [GitHub @darsh-7](https://github.com/darsh-7) · [LinkedIn](https://www.linkedin.com/in/darsh7/)
