import React, {Component} from "react";
import StudentService from '../StudentService.js';

class CreateStudentComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            firstName: '',
            lastName: '',
            emailId: '',
            age: '',
            teacher: ''
            
        }
        this.changeFirstNameHandler = this.changeFirstNameHandler.bind(this);
        this.changeLastNameHandler = this.changeLastNameHandler.bind(this);
        this.changeEmailHandler = this.changeEmailHandler.bind(this);
        this.changeAgeHandler = this.changeAgeHandler.bind(this);
        this.changeTeacherNameHandler = this.changeTeacherNameHandler.bind(this);
        this.saveOrUpdateStudent = this.saveOrUpdateStudent.bind(this);

    }

    ComponentDidMount() {

        if(this.state.id === '_add'){
            return
        }else {
            StudentService.getStudentById(this.state.id).then(res => {
                let student = res.data;
                this.setState({
                    firstName : student.firstName,
                    lastName  : student.lastName,
                    emailId   : student.emailId,
                    age       : student.age,
                    teacher   : student.teacher
                });
            });
        }
    }

    saveOrUpdateStudent = (e) => {
        e.preventDefault();
        let student = {firstName: this.state.firstName, lastName: this.state.lastName,emailId: this.state.emailId, age: this.state.age,teacher: this.state.teacher};
        console.log('Student => ' + JSON.stringify(student));

        if (this.state.id === '_add') {
            StudentService.createStudent(student).then(res => {
                this.props.history.push('/students');
            });
        } else {
            StudentService.updateStudent(student,this.state.id).then(res => {
                this.props.history.push('/students');
            });
        }
    }

    changeFirstNameHandler = (event) => {
        this.setState({firstName: event.target.value});
    }
    changeLastNameHandler = (event) => {
        this.setState({lastName: event.target.value});
    }
    changeEmailHandler = (event) => {
        this.setState({emailId: event.target.value});
    }
    changeAgeHandler = (event) => {
        this.setState({age: event.target.value});
    }
    changeTeacherNameHandler = (event) => {
        this.setState({teacher: event.target.value});
    }

    getTitle() {
       if (this.state.id === '_add') {
        return <h3 className = "text-center">ADD STUDENT</h3>
       }else {
        return <h3 className = "text-center">UPDATE STUDENT</h3>
       }
    }
    render(){
        return(
            <div>
                <br></br>
                <div className ="container">
                <div className="row">
                        <div className="card col-md-6 offset-md-3 offset-md-3">
                            {
                                this.getTitle()
                            }
                            </div>
                            </div>
                    </div>
            </div>

        )
    }
}
export default CreateStudentComponent