# 株式会社ゆめみ Android エンジニアコードチェック課題

## 概要

本プロジェクトは株式会社ゆめみ（以下弊社）が、弊社に Android エンジニアを希望する方に出す課題のベースプロジェクトです。本課題が与えられた方は、下記の概要を詳しく読んだ上で課題を取り組んでください。

## アプリ仕様

本アプリは GitHub のリポジトリを検索するアプリです。

<img src="docs/app.gif" width="320">

### 環境

- IDE：Android Studio Arctic Fox | 2020.3.1 Patch 1
- Kotlin：1.6.10
- Java：11
- Gradle：7.4
- minSdk：23
- targetSdk：31

### ライブラリ
- Kotlin Coroutines: 1.5.2 
- Kotlinx Datetime: 0.3.2
- Jetpack Compose: 1.2.0-alpha04
- Hilt: 2.38.1
- Kotlinx Serialization: 1.3.2
- Ktor: 1.6.4
- Room: 2.4.1
- Coil: 1.4.0
- KtLint: 10.2.1
- Leak Canary: 2.8.1
- Dokka: 1.6.10

### テストスイート
- Androidx Test Core: 1.4.0
- Junit: 4.13.2
- Turbine: 0.7.0
- Mockk: 1.12.2
- Kotest: 5.1.0
- CodeCov

### その他
- CircleCI: 2.1
- OpenApi Generator: 5.4.0 

### DEMO
Githubの正式アプリの仕様・デザインに合わせて実装した

| 正式 | サンプル |
|---|---|
|<img width="300" alt="Actual" src="https://user-images.githubusercontent.com/9910583/156286920-934e3875-8255-4d58-a0a9-823302b37013.gif">|<img width="300" alt="Sample" src="https://user-images.githubusercontent.com/9910583/156286989-f897c8e8-0adf-4d8d-9bc3-0b2829920d9f.gif">|

### 動作

1. 何かしらのキーワードを入力
2. GitHub API（`search/repositories`）でリポジトリを検索し、結果一覧を概要（リポジトリ名）で表示
3. 特定の結果を選択したら、該当リポジトリの詳細（リポジトリ名、オーナーアイコン、プロジェクト言語、Star 数、Watcher 数、Fork 数、Issue 数）を表示

## 課題取り組み方法

Issues を確認した上、本プロジェクトを [**Duplicate** してください](https://help.github.com/en/github/creating-cloning-and-archiving-repositories/duplicating-a-repository)（Fork しないようにしてください。必要ならプライベートリポジトリにしても大丈夫です）。今後のコミットは全てご自身のリポジトリで行ってください。

コードチェックの課題 Issue は全て [`課題`](https://github.com/yumemi-inc/android-engineer-codecheck/milestone/1) Milestone がついており、難易度に応じて Label が [`初級`](https://github.com/yumemi-inc/android-engineer-codecheck/issues?q=is%3Aopen+is%3Aissue+label%3A初級+milestone%3A課題)、[`中級`](https://github.com/yumemi-inc/android-engineer-codecheck/issues?q=is%3Aopen+is%3Aissue+label%3A中級+milestone%3A課題+) と [`ボーナス`](https://github.com/yumemi-inc/android-engineer-codecheck/issues?q=is%3Aopen+is%3Aissue+label%3Aボーナス+milestone%3A課題+) に分けられています。課題の必須／選択は下記の表とします。

|   | 初級 | 中級 | ボーナス
|--:|:--:|:--:|:--:|
| 新卒／未経験者 | 必須 | 選択 | 選択 |
| 中途／経験者 | 必須 | 必須 | 選択 |

課題 Issueをご自身のリポジトリーにコピーするGitHub Actionsをご用意しております。  
[こちらのWorkflow](./.github/workflows/copy-issues.yml)を[手動でトリガーする](https://docs.github.com/ja/actions/managing-workflow-runs/manually-running-a-workflow)ことでコピーできますのでご活用下さい。

課題が完成したら、リポジトリのアドレスを教えてください。

## 参考記事

提出された課題の評価ポイントに関しては、[こちらの記事](https://qiita.com/blendthink/items/aa70b8b3106fb4e3555f)に詳しく書かれてありますので、ぜひご覧ください。
