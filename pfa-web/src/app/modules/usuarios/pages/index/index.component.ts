import { Component, OnInit } from '@angular/core';
import { Banda } from 'src/app/core/models/banda';
import { BandasService } from 'src/app/core/services/api/bandas.service';

import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { ModalResult } from 'src/app/shared/extensions/ModalResult';
import { Usuario } from 'src/app/core/models/Usuario';
import { UsuariosService } from 'src/app/core/services/api/usuarios.service';
import { UsuariosEditComponent } from '../edit/edit.component';

@Component({
    selector: 'bandas-index',
    templateUrl: 'index.component.html'
})

export class UsuariosIndexComponent implements OnInit {
    usuarios: Usuario[];

    constructor(private usuariosService:UsuariosService,
        private modalService: NgbModal) {
    }

    async ngOnInit() {
        this.getAll();
    }

    async getAll() {
        this.usuarios = await this.usuariosService.getAll();
    }

    async edit(usuario: Usuario) {
        const modalRef = this.modalService.open(UsuariosEditComponent);

        if (usuario) {
            modalRef.componentInstance.codigo = usuario.id;
        }

        var result = await modalRef.result;
        debugger;
        if (result == ModalResult.Ok) {
            this.getAll();
        }
    }

    async delete($event, usuario: Usuario) {
        debugger;
        await this.usuariosService.delete(usuario.id);
        this.getAll();
        $event.stopPropagation();
    }
}