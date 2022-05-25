import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Educacion } from 'src/app/model/educacion';
import { EducacionService } from 'src/app/service/educacion.service';

@Component({
  selector: 'app-educacion',
  templateUrl: './educacion.component.html',
  styleUrls: ['./educacion.component.css']
})
export class EducacionComponent implements OnInit {

  public educacions:Educacion[]=[];

  constructor(private educacionService : EducacionService) { }

  ngOnInit(): void {

    this.getEducacion();
  }

  public getEducacion(): void {
    this.educacionService.getEducacion().subscribe({
      next: (Response: Educacion[]) => {
        this.educacions = Response;
      },
      error: (error:HttpErrorResponse)=>{
        alert(error.message);
      }
    })
  }



}
