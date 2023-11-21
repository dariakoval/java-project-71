# Difference calculator CLI Utility

## Tests and linter status
[![Actions Status](https://github.com/dariakoval/java-project-71/actions/workflows/hexlet-check.yml/badge.svg)](https://github.com/dariakoval/java-project-71/actions)                [![Java CI](https://github.com/dariakoval/java-project-71/actions/workflows/generate.yml/badge.svg)](https://github.com/dariakoval/java-project-71/actions/workflows/generate.yml)                [![Maintainability](https://api.codeclimate.com/v1/badges/24b9f20c4dde45de5998/maintainability)](https://codeclimate.com/github/dariakoval/java-project-71/maintainability)              [![Test Coverage](https://api.codeclimate.com/v1/badges/24b9f20c4dde45de5998/test_coverage)](https://codeclimate.com/github/dariakoval/java-project-71/test_coverage)

## Description
This application compares two configuration files, taking two arguments through the command line - the paths to these files. The result of file comparison can be displayed in different formats: stylish(default), plain and json.

*To learn more about usage, go to asciinemas.*

## Asciinemas 
- output of help information
[![asciicast](https://asciinema.org/a/1F1ReFztilrot8PTso5iyekcc.svg)](https://asciinema.org/a/1F1ReFztilrot8PTso5iyekcc)

- [finding differences between two flat (only key-value pairs) json files](https://asciinema.org/a/EIvQNFr5uwc1SFklNgOzjX9VL)

- [finding differences between two flat (only key-value pairs) yaml files](https://asciinema.org/a/kpg3ACJcF3Ob6ayHthC1ZtW2S)

- [finding differences between two json files with nested structures](https://asciinema.org/a/gzIu4xTyPxDUA07vwJRm6bsNI)

- [finding differences between two yaml files with nested structures](https://asciinema.org/a/CiRn1wJrhq1Jr8Hx0PrRc9sUZ)

- [finding differences between two yaml files with output in plain format](https://asciinema.org/a/DD7mzjm02D7dBnHBYcTWWi51u)

- [finding differences between two json files with output in json format](https://asciinema.org/a/6fV2jBGXCzCUWDkpu7bsWNgMi)

## Build
```bash
make build
```

## Run

```bash
make run-dist
```

## Test

```bash
make test
```
