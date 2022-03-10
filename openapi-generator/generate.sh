rm -rf openapi-generator/output
mkdir openapi-generator/output

rm -rf ./remote/src/main/kotlin/io/github/gmvalentino8/github/sample/remote/models || true
rm -rf ./remote/src/main/kotlin/io/github/gmvalentino8/github/sample/remote/apis || true

java -jar ./openapi-generator/openapi-generator-cli.jar generate \
-c ./openapi-generator/openapi_generator_config.json \
-o ./openapi-generator/output \
--global-property models,apis

cp -rf ./openapi-generator/output/src/main/kotlin/io/github/gmvalentino8/github/sample/remote/models ./remote/src/main/kotlin/io/github/gmvalentino8/github/sample/remote/models
cp -rf ./openapi-generator/output/src/main/kotlin/io/github/gmvalentino8/github/sample/remote/apis ./remote/src/main/kotlin/io/github/gmvalentino8/github/sample/remote/apis
rm -rf openapi-generator/output
