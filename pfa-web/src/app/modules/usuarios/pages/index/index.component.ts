import { Component, OnInit } from '@angular/core';
import { Usuario } from 'src/app/core/models/usuario';
import { UsuariosService } from 'src/app/core/services/api/usuarios.service';
import { UsuariosEditComponent } from '../edit/edit.component';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { ModalResult } from 'src/app/shared/extensions/ModalResult';

@Component({
    selector: 'usuarios-index',
    templateUrl: 'index.component.html'
})

export class UsuariosIndexComponent implements OnInit {
    usuarios: Usuario[];

    constructor(private usuariosService: UsuariosService,
        private modalService: NgbModal) { }

    async ngOnInit() {
        this.getAll();
    }

    async getAll() {
        debugger;
        this.usuarios = await this.usuariosService.getAll();
    }

    async edit(usuario: Usuario) {
        const modalRef = this.modalService.open(UsuariosEditComponent);

        if (usuario) {
            modalRef.componentInstance.id = usuario.id;
        }

        var result = await modalRef.result;
        debugger;
        if (result == ModalResult.Ok) {
            this.getAll();
        }
    }

    async delete($event, usuario: Usuario) {
        console.log(usuario);
        await this.usuariosService.delete(usuario.id);
        this.getAll();
        $event.stopPropagation();
    }
}