rm -rf openapi-generator/output
mkdir openapi-generator/output

rm -rf ./data/src/main/kotlin/jp/co/yumemi/android/code_check/data/models || true
rm -rf ./remote/src/main/kotlin/jp/co/yumemi/android/code_check/remote/apis || true

java -jar ./openapi-generator/openapi-generator-cli.jar generate \
-c ./openapi-generator/openapi_generator_config.json \
-o ./openapi-generator/output \
--global-property models,apis

cp -rf ./openapi-generator/output/src/main/kotlin/jp/co/yumemi/android/code_check/data/models ./data/src/main/kotlin/jp/co/yumemi/android/code_check/data/models
cp -rf ./openapi-generator/output/src/main/kotlin/jp/co/yumemi/android/code_check/remote/apis ./remote/src/main/kotlin/jp/co/yumemi/android/code_check/remote/apis
rm -rf openapi-generator/output
