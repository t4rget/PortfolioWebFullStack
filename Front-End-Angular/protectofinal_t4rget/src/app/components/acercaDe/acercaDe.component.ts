import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Persona } from 'src/app/model/persona';
import { LoginService } from 'src/app/service/login.service';
import { PersonaService } from 'src/app/service/persona.service';

@Component({
  selector: 'app-acercaDe',
  templateUrl: './acercaDe.component.html',
  styleUrls: ['./acercaDe.component.css']
})
export class AcercaDeComponent implements OnInit {

  public persona : Persona | undefined;
  public editPersona : Persona | undefined;
  public editaPersona : Persona | undefined;
  public estaLogeado : Boolean | undefined;

  constructor(private personaService : PersonaService, private loginService : LoginService) {
    this.loginService.estadoLogeadoSubject.subscribe(data => {
      this.estaLogeado=data;
    });
   }

  ngOnInit(): void {

    this.getPersona()

  }


  /*public getPersona():void{
    this.personaService.getPersona().subscribe({
      next: (response: Persona) =>{
        this.persona=response;
      },
      error:(error:HttpErrorResponse)=>{
        alert(error.message);
      }
    })
  }*/

    /*this.persona.getPersona().subscribe(data => {
      console.log("datos personales"+JSON.stringify(data));
      this.persona=data[0]
    });*/



  public getPersona():void{
    this.personaService.getPersona().subscribe({
      next: (Response: Persona) =>{
        this.persona=Response;
      },
      error:(error:HttpErrorResponse)=>{
        alert(error.message);
      }
    })
  }


  public onOpenModal(mode:String, persona?: Persona):void{
    const container=document.getElementById('main-container');
    const button=document.createElement('button');
    button.type="button";
    button.style.display='none';
    button.setAttribute('data-toggle', 'modal');
    if(mode==='add'){
      button.setAttribute('data-target', '#addPersonaModal');
    }else if(mode==='edit'){
      this.editPersona = persona;
      button.setAttribute('data-target', '#editPersonaModal')
    }else if(mode==='edita'){
      this.editaPersona = persona;
      button.setAttribute('data-target', '#editaPersonaModal')
    }/*else if(mode==='delete'){
      this.deletePersona = persona;
      button.setAttribute('data-target', '#deletePersonaModal')
    }*/
    container?.appendChild(button);
    button.click();
  }

  public onAddPersona(addForm: NgForm): void{
    document.getElementById('add-persona-form')?.click();
    this.personaService.addPersona(addForm.value).subscribe({
      next: (response:Persona) =>{
        console.log(response);
        this.getPersona();
        addForm.reset();
      },
      error: (error:HttpErrorResponse)=>{
        alert(error.message);
        addForm.reset();
      }
    })
  }

  public onUpdatePersona(persona: Persona){
    this.editPersona=persona;
    document.getElementById('add-persona-form')?.click();
    this.personaService.updatePersona(persona).subscribe({
      next: (response:Persona) =>{
        console.log(response);
        this.getPersona();
      },
      error: (error:HttpErrorResponse)=>{
        alert(error.message);
      }
    })
  }

  public onUpdatePersonaa(persona: Persona){
    this.editaPersona=persona;
    document.getElementById('add-persona-form')?.click();
    this.personaService.updatePersona(persona).subscribe({
      next: (response:Persona) =>{
        console.log(response);
        this.getPersona();
      },
      error: (error:HttpErrorResponse)=>{
        alert(error.message);
      }
    })
  }

}
