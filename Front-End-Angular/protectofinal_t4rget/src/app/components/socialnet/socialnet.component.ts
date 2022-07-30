import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Redes } from 'src/app/model/redes';
import { LoginService } from 'src/app/service/login.service';
import { RedesService } from 'src/app/service/redes.service';

@Component({
  selector: 'app-socialnet',
  templateUrl: './socialnet.component.html',
  styleUrls: ['./socialnet.component.css']
})
export class SocialnetComponent implements OnInit {

  public redess:Redes[]=[];
  public editRedes: Redes | undefined;
  public deleteRedes: Redes | undefined;
  public estaLogeado: Boolean | undefined;

  constructor(private redesService : RedesService, private loginService : LoginService) {
    this.loginService.estadoLogeadoSubject.subscribe(data => {
      this.estaLogeado = data;
    });
   }

  ngOnInit(): void {

    this.getRedes();
  }

  public getRedes(): void {
    this.redesService.getRedes().subscribe({
      next: (Response: Redes[]) => {
        this.redess = Response;
      },
      error: (error:HttpErrorResponse)=>{
        alert(error.message);
      }
    })
  }

  public onOpenModal(mode:String, redes?: Redes):void{
    const container=document.getElementById('main-container');
    const button=document.createElement('button');
    button.type="button";
    button.style.display='none';
    button.setAttribute('data-toggle', 'modal');
    if(mode==='add'){
      button.setAttribute('data-target', '#addRedesModal');
    }else if(mode==='delete'){
      this.deleteRedes = redes;
      button.setAttribute('data-target', '#deleteRedesModal')
    }else if(mode==='edit'){
      this.editRedes = redes;
      button.setAttribute('data-target', '#editRedesModal')
    }
    container?.appendChild(button);
    button.click();
  }

  public onAddRedes(addForm: NgForm): void{
    document.getElementById('add-redes-form')?.click();
    this.redesService.addRedes(addForm.value).subscribe({
      next: (response:Redes) =>{
        console.log(response);
        this.getRedes();
        addForm.reset();
      },
      error: (error:HttpErrorResponse)=>{
        alert(error.message);
        addForm.reset();
      }
    })
  }


  public onUpdateRedes(redes: Redes){
    this.editRedes=redes;
    document.getElementById('add-redes-form')?.click();
    this.redesService.updateRedes(redes).subscribe({
      next: (response:Redes) =>{
        console.log(response);
        this.getRedes();
      },
      error: (error:HttpErrorResponse)=>{
        alert(error.message);
      }
    })
  }


  public onDeleteRedes(idRed: number):void{
    this.redesService.deleteRedes(idRed).subscribe({
      next: (response:void) =>{
        console.log(response);
        this.getRedes();
      },
      error: (error:HttpErrorResponse)=>{
        alert(error.message);
      }
    })
  }

}
