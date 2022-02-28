# reference: https://danger.systems/reference.html


# warnings
github.dismiss_out_of_range_messages
warn("Big PR") if git.lines_of_code > 500
can_merge = github.pr_json["mergeable"]
warn("This PR cannot be merged yet.", sticky: false) unless can_merge

# danger-android_lint
# reference: https://github.com/loadsmart/danger-android_lint
android_lint.skip_gradle_task = true
android_lint.filtering = true

android_lint_dir_pattern = "**/build/reports/lint-results-debug.xml"
Dir.glob(android_lint_dir_pattern) do |file|
  android_lint.report_file = file
  android_lint.lint(inline_mode: true)
end

# danger-checkstyle_format
# ref: https://github.com/noboru-i/danger-checkstyle_format
checkstyle_format.base_path = Dir.pwd

# ktlint
ktlint_dir_pattern = "**/build/reports/ktlint/*/*.xml"
Dir.glob(ktlint_dir_pattern) do |file|
  checkstyle_format.report file
end

if status_report[:warnings].empty?
  markdown("No lint issues were reported")
else
  markdown("No error was reported but at least one warning was found.")
end
