from .models import DafLearning1
from .serializers import DafLearning1Serializer
from rest_framework import generics

# Create your views here.

class DafLearning1List(generics.ListCreateAPIView):
    queryset = DafLearning1.objects.all()
    serializer_class = DafLearning1Serializer

class DafLearning1Detail(generics.RetrieveUpdateDestroyAPIView):
    queryset = DafLearning1.objects.all()
    serializer_class = DafLearning1Serializer