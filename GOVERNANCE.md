# Governance

This document describes the governance of the FINOS Flowave project. The project is also governed by the [Linux Foundation Antitrust Policy](https://www.linuxfoundation.org/antitrust-policy/), and the FINOS [IP Policy]( https://community.finos.org/governance-docs/IP-policy.pdf), [Code of Conduct](https://community.finos.org/docs/governance/code-of-conduct), [Collaborative Principles](https://community.finos.org/docs/governance/collaborative-principles/), and [Meeting Procedures](https://community.finos.org/docs/governance/meeting-procedures/).

Please also see our [contribution guidelines] (https://github.com/finos/flowave-bpm-platform/blob/main/CONTRIBUTING.md)

## Roles

Flowave is a meritocratic, consensus-based community project, in so far that is possible, decision-making is done based on user consensus following open discussion on our Working Groups and issue list. No major decisions about the project’s direction, bug fixes, or features should be made in private without community involvement and participation. Discussions must begin at the earliest possible point on a topic; the community’s participation is vital during the entire decision-making process.

### Contributors

A Contributor is anyone who submits a contribution to the project. Contributions may include code, issues, documentation, comments, tests or design inputs.

#### (CLA) Contributor License Agreement 

Contributors must be covered under a Contributor License Agreement (CLA) with FINOS. Contributions from those not covered will be blocked by the Linux Foundation EasyCLA tool. See the [FINOS Software Project Governance](https://community.finos.org/docs/governance/software-projects/easycla/) page for more details.


### Maintainers

A Maintainer is a Contributor who, based on sustained contributions and community trust is granted write access to the Flowave repositories. Maintainers are responsible for:

- Reviewing and merging pull requests
- Managing GitHub issues and labels
- Participating in community discussions
- Ensuring adherence to project standards


###	Lead Maintainers

The Lead Maintainer serves as the primary liaison(s) with the FINOS team and FINOS Board. Responsibilities include:

- Approving and submitting reports to FINOS.
- Representing the project at FINOS-wide forums.
- Facilitating consensus across Maintainers.
- Casting tie-breaking votes if needed.

The Lead Maintainer is elected by majority vote of the Maintainers.

## Maintainer Lifecycle

Flowave encourages community driven stewardship. The following practices ensure the Maintainer group remains active, representative and aligned with project goals:

- Appointment: Any contributor with a sustained track record may be nominated or may apply to become a Maintainer. Approval requires the consensus of the maintainers see [Decision Making Process](#decision-making-process).
- Annual Review: The list of Maintainers is reviewed annually. The next review and refresh will occur in Q1 2026, unless otherwise agreed by the Working Group. While the annual review serves as a structured checkpoint, new maintainers may be added at any point throughout the year. Proposed additions must first seek consensus amongst existing maintainers, and where consensus cannot be reached, the voting mechanism described in [Decision Making Process](#decision-making-process) will apply.
- Lead Maintainer Re-election: The Lead Maintainer(s) is re-elected annually, or earlier if required. Any current Maintainer may nominate themselves or others. Elections are conducted by majority vote.
- Transparency: All discussions and decisions on Maintainer appointments, removals, or Lead Maintainer elections are recorded and minuted publicly.
- Offboarding: As part of the Annual Maintainer Review, all maintainers will be asked to:
    - Reconfirm their commitment to the project
    - Share any availability constraints
    - Optionally step down if unable to contribute actively
Inactivity Criteria: A maintainer may be considered inactive if, for 6+ months they have not:
- Reviewed or merged PRs,
- Participated in governance or roadmap discussions
- Attended calls or asynchronous decisions e.g. GitHub issues, Email chains, Shared documents
Offboarding:
- Voluntary: Maintainers may step down at any time
- Involuntary: If inactive and unresponsive, maintainers may be respectfully offboarded through consensus
    - Note: Any offboarding decisions will be handled with care and reviewed against the FINOS policies to ensure alignment with community and legal standards

## Contribution Guidelines

Contributions must abide by the contribution guidelines set out in [CONTRIBUTING.md](https://github.com/finos/flowave-bpm-platform/blob/main/CONTRIBUTING.md) 

## Decision Making Process

Flowave follows a consensus- based decision-making model:

- Preferred: All relevant Maintainer agree
- Acceptable: Majority agrees, no strong objections
- If consensus cannot be achieved, Maintainers vote per [Maintainer Voting](#maintainer-voting)

## Maintainer Voting

Maintainers may hold votes when consensus is not achievable. Any Maintainer may call for a vote. Voting rules:

- Maintainers have 36 hours to vote: +1 (Agree), -1 (Disagree), +0 (Abstain)
- Majority of votes cast determines the outcome
- If tied, the Lead Maintainer may cast a tie-breaking vote

Votes MUST be public, taking place via:
- GitHub (Issues)
- Public communication channels (mailing list)
- Minuted project meetings

Voting may be required but not limited to:

- Contested pull requests
- Future roadmap decisions
- Appointing or removing Maintainers
- Electing or removing the Lead Maintainer
- Amendments to governance documents

## Working Group Structure

Flowave operates two standing Working Groups, to streamline both technical collaboration and strategic oversight. Additional working groups may be formed, from time to time, to work on specific topics.

### Maintainers Working Group

- Purpose: Technical forum for Maintainers to discuss engine code, new features, build pipelines and CI automation
- Duration: 60 minutes
- Responsibilities: 
    - Review and merge open pull requests
    - Discuss architecture and design proposals
    - Ensure compliance with FINOS governance and open-source best practices

### General Working Group

- Purpose: Programme level forum that escalates items from the Maintainers Working Group and steers overall delivery
- Duration: 30 minutes
- Responsibilities: 
    - Oversee roadmap milestones and delivery targets
    - Review and approve major technical changes that require wider agreement
    - Ensure ongoing alignment with FINOS governance and open-source best practices

### Meeting Cadence and Chair Rotation
Both Working Groups meet weekly and all sessions are minuted and published publicly.

| Period | Chair & Minutes |
| ------ | --------------- |
|Q2 2025 | NatWest |
|Q3 2025 | Fidelity |
|Q4 2025 | Deutsche |
|Q1 2026 | Capital One |

Chair Responsibilities:
- Set agendas and create meeting issues in GitHub
- Facilitate the call and manage time
- Ensure minutes capture key decisions and assigned actions
- Track action follow up and escalate risks or blockers as needed

## Community Participation

Flowave follows consensus-based decision-making process, the guiding principles for participation include:

### Openness

Participation is open to all who are materially affected by Flowave’s direction. There are no financial barriers or affiliation requirements to contribute.

### Lack of Dominance

No single individual company, or interest group shall dominate decision making. Contributions are considered on their merit.

### Balance
Efforts are made to involve diverse stakeholders across industry sectors to ensure well rounded and equitable outcomes.

### Consideration of Views and Objections

All feedback, objections and comments from contributors shall be thoroughly reviewed. Maintainers are responsible for recording responses and actions.

## Changes to this Document

This document MAY be amended by consensus of the Maintainers, see [Decision Making Process](#decision-making-process).
