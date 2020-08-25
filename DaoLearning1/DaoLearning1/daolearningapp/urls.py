from .models import DafLearning1
from django.urls import path
from . import views

urlpatterns = [
    path('daflearning', views.DafLearning1List.as_view(), name="daflearning_list"),
    path('daflearning/<int:pk>', views.DafLearning1Detail.as_view(), name="daflearning_detail"),
]