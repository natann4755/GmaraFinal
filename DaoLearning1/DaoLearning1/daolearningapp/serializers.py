from rest_framework import serializers
from .models import DafLearning1

class DafLearning1Serializer(serializers.ModelSerializer):
    class Meta:
        model = DafLearning1
        fields = ['id', 'indexTypeOfStudy', 'masechet', 'pageNumber',
                  'isLearning', 'chazara', 'isLearningPage1', 'isLearningPage2',
                  'typeOfStudy', 'pageDate']


