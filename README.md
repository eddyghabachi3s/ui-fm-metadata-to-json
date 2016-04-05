# Description
A quick tool to transform CSV/TSV metadata about feature model from Excel file to JSON in order to be used inside the GUI. 
This tool use columns names in order to produce the output, the column names considered are (:warning: the case sensitity is important here)
* **id**
* **Type**
* **Name**
* **Short description**
* **Question (y/n)**
* **Question/Affirmation**
* **Description**
* **Examples**
* **Logo (url)**
* **Visible (y/n)**
* **Display if selected (y/n)**
* **Reference(s)**

For column with boolean values the value `y` is associated with `true`: every other value will be considered as `false`.

## Compilation: 
`mvn clean package`

## Usage:
`java -jar target/ui-fm-metadata-generator.jar <input> [output]`

### `<input>`

This mandatory argument is a path to a CSV/TSV file.
The name of the file will determined the parser used in the tool : 
* **/my/path/file.csv** will use a standard parser for CSV
* **/my/path/file.tsv** will use a standard parser for TSV 
* **/my/path/file.excel.csv** will use a standard parser for Excel CSV

See [Apache Commons CSV Javadoc for definition on CSV/TSV or Excel CSV](https://commons.apache.org/proper/commons-csv/archives/1.2/apidocs/org/apache/commons/csv/CSVFormat.html).

### `[output]`

This argument is optional and can be either a file or a directory representing the output path or file.
If it is omitted the output will be in the current directory in the file **output.json**.

If a file or a path is given, the directory are automatically created in order to produce the output.
If only a directory path is given, the output will be in **/given/path/output.json**.
If the the output is an existing file, the program will stop with an error.
