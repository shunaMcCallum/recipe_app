import React from 'react';
import InstructionListItem from './InstructionListItem';

const InstructionList = ({instructionList}) => {
  
    const instructionItems = instructionList.map((instruction, index) => {
        return <InstructionListItem instruction={instruction} key={index} />
    })

    return (
        <div className="instruction-list">
            {instructionItems}
        </div>
    )
}

export default InstructionList;