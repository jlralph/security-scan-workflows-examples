const core = require('@actions/core');

try {
  // Get input
  const inputName = core.getInput('input-name');
  
  // Do something with the input
  console.log(`Processing: ${inputName}`);
  
  // Set output
  core.setOutput('output-name', `Processed: ${inputName}`);
  
} catch (error) {
  core.setFailed(error.message);
}