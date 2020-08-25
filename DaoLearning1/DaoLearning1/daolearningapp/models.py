from django.db import models

# Create your models here.
class DafLearning1(models.Model):
    indexTypeOfStudy = models.IntegerField()
    masechet = models.TextField(max_length=50)
    pageNumber = models.IntegerField()
    isLearning = models.BooleanField()
    chazara = models.IntegerField()
    isLearningPage1 = models.BooleanField()
    isLearningPage2 = models.BooleanField()
    typeOfStudy = models.TextField(max_length=50)
    pageDate = models.TextField(max_length=50)
