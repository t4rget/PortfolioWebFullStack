import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Aptitud } from 'src/app/model/aptitud';
import { AptitudService } from 'src/app/service/aptitud.service';


@Component({
  selector: 'app-hyss',
  templateUrl: './hyss.component.html',
  styleUrls: ['./hyss.component.css']
})
export class HyssComponent implements OnInit {

  public aptitudes:Aptitud[]=[];
  public editAptitud: Aptitud | undefined;
  public deleteAptitud: Aptitud | undefined;

  constructor(private aptitudService : AptitudService) { }

  ngOnInit(): void {

    this.getAptitud();
  }

  public getAptitud(): void {
    this.aptitudService.getAptitud().subscribe({
      next: (Response: Aptitud[]) => {
        this.aptitudes = Response;
      },
      error: (error:HttpErrorResponse)=>{
        alert(error.message);
      }
    })
  }

  public onOpenModal(mode:String, aptitud?: Aptitud):void{
    const container=document.getElementById('main-container');
    const button=document.createElement('button');
    button.type="button";
    button.style.display='none';
    button.setAttribute('data-toggle', 'modal');
    if(mode==='add'){
      button.setAttribute('data-target', '#addAptitudModal');
    }else if(mode==='delete'){
      this.deleteAptitud = aptitud;
      button.setAttribute('data-target', '#deleteAptitudModal')
    }else if(mode==='edit'){
      this.editAptitud = aptitud;
      button.setAttribute('data-target', '#editAptitudModal')
    }
    container?.appendChild(button);
    button.click();
  }


  public onAddAptitud(addForm: NgForm): void{
    document.getElementById('add-aptitud-form')?.click();
    this.aptitudService.addAptitud(addForm.value).subscribe({
      next: (response:Aptitud) =>{
        console.log(response);
        this.getAptitud();
        addForm.reset();
      },
      error: (error:HttpErrorResponse)=>{
        alert(error.message);
        addForm.reset();
      }
    })
  }


  public onUpdateAptitud(aptitud: Aptitud){
    this.editAptitud=aptitud;
    document.getElementById('add-aptitud-form')?.click();
    this.aptitudService.updateAptitud(aptitud).subscribe({
      next: (response:Aptitud) =>{
        console.log(response);
        this.getAptitud();
      },
      error: (error:HttpErrorResponse)=>{
        alert(error.message);
      }
    })
  }


  public onDeleteAptitud(idEdu: number):void{
    this.aptitudService.deleteAptitud(idEdu).subscribe({
      next: (response:void) =>{
        console.log(response);
        this.getAptitud();
      },
      error: (error:HttpErrorResponse)=>{
        alert(error.message);
      }
    })
  }


}
