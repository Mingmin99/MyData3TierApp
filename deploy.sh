#!/bin/bash

REPOSITORY_URI=$1
IMAGE_TAG=$2

echo "Updating task definition..."
sed -i 's|IMAGE_URI|'"$REPOSITORY_URI:$IMAGE_TAG"'|g' taskdef.json
TASK_DEFINITION_ARN=$(aws ecs register-task-definition --cli-input-json file://taskdef.json --query 'taskDefinition.taskDefinitionArn' --output text)
echo "Task definition registered: $TASK_DEFINITION_ARN"

echo "Writing AppSpec file..."
sed 's|LATEST_TASK_DEFINITION_ARN_PLACEHOLDER|'"$TASK_DEFINITION_ARN"'|g' appspec.yml > appspec-temp.yml

echo "Triggering deployment..."
aws deploy create-deployment \
  --application-name AppECS-app-cluster-was-service \
  --deployment-group-name DgpECS-app-cluster-was-service \
  --revision "{\"revisionType\": \"AppSpecContent\", \"appSpecContent\": {\"content\": \"$(cat appspec-temp.yml | jq -Rs .)\"}}"
