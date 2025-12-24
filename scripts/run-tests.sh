
#!/bin/bash
# Script to execute K6 load tests
k6 run -e VUS=100 ../../loadtests/k6/create_small.js
